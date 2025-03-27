ARG GEM_FOLDER="/usr/local/bundle"

ARG BASE_IMAGE=ruby:3.2-alpine3.21

FROM $BASE_IMAGE as doc-generator

ARG GEM_FOLDER
ENV GEM_HOME=$GEM_FOLDER
ENV PATH $GEM_HOME/bin:$GEM_HOME/gems/bin:$PATH
WORKDIR /doc_generator

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console \
    ruby-bigdecimal make gcc ruby-json libstdc++ tzdata bash \
    libc-dev yaml-dev libpq-dev openjdk17-jre

COPY Gemfile .
COPY Gemfile.lock . 

COPY doc_generation /doc_generator/doc_generation
COPY scripts /doc_generator/scripts
COPY docs docs

RUN echo 'gem: --no-document' > /etc/gemrc \
    && bundle install \
    && gem cleanup  \
    && rm -rf /tmp/* /var/cache/apk/* 

RUN bundle config set --local path 'vendor/bundle' && bundle install && gem cleanup && ./scripts/doc_generate.sh .

FROM $BASE_IMAGE

ARG GEM_FOLDER
ENV GEM_HOME=$GEM_FOLDER
ENV PATH $GEM_HOME/bin:$GEM_HOME/gems/bin:$PATH

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console ruby-bigdecimal ruby-json \ 
    openjdk17-jre \
    bash

COPY --from=doc-generator /usr/local/bundle /usr/local/bundle
COPY --from=doc-generator /doc_generator/docs /docs

RUN adduser --uid 2004 --disabled-password --gecos "" docker
RUN chown -R docker:docker /usr/local/bundle
COPY /target/universal/stage/ /workdir/
RUN chmod +x /workdir/bin/codacy-rubocop
USER docker
WORKDIR /workdir
ENTRYPOINT ["bin/codacy-rubocop"]
