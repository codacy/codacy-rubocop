ARG GEM_FOLDER="/usr/local/bundle"

ARG BASE_IMAGE=alpine:3.17.3

FROM $BASE_IMAGE as doc-generator

ARG GEM_FOLDER
ENV GEM_HOME=$GEM_FOLDER
ENV PATH $GEM_HOME/bin:$GEM_HOME/gems/bin:$PATH
WORKDIR /doc_generator

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console \
    ruby-bigdecimal make gcc ruby-json libstdc++ tzdata bash \
    ca-certificates libc-dev openjdk11 openjdk8-jre

COPY Gemfile .
COPY Gemfile.lock .

RUN echo 'gem: --no-document' > /etc/gemrc \
    && gem install bundler -v 2.2.16 \
    && bundle install \
    && gem cleanup \
    && rm -rf /tmp/* /var/cache/apk/*

COPY doc_generation /doc_generator/doc_generation
COPY scripts /doc_generator/scripts
COPY docs docs

RUN bundle update && bundle config set --local path 'vendor/bundle' && bundle install && ./scripts/doc_generate.sh .

FROM $BASE_IMAGE

ARG GEM_FOLDER
ENV GEM_HOME=$GEM_FOLDER
ENV PATH $GEM_HOME/bin:$GEM_HOME/gems/bin:$PATH

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console ruby-bigdecimal ruby-json \ 
    openjdk8-jre \
    bash

COPY --from=doc-generator /usr/local/bundle /usr/local/bundle
COPY --from=doc-generator /doc_generator/docs /docs

RUN adduser --uid 2004 --disabled-password --gecos "" docker
COPY target/universal/stage/ /workdir/
RUN chmod +x /workdir/bin/codacy-rubocop
USER docker
WORKDIR /workdir
ENTRYPOINT ["bin/codacy-rubocop"]
