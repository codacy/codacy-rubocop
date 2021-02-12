FROM alpine:3.13 as base-image

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console \
    ruby-bigdecimal make gcc ruby-json libstdc++ tzdata bash \
    ca-certificates libc-dev openjdk11 openjdk8-jre

COPY Gemfile .
COPY Gemfile.lock .

RUN echo 'gem: --no-document' > /etc/gemrc \
    && gem install bundler -v 2.2.7 \
    && bundle install \
    && gem cleanup \
    && rm -rf /tmp/* /var/cache/apk/*

FROM base-image as doc-generator

WORKDIR /doc_generator

COPY doc_generation /doc_generator/doc_generation
COPY scripts /doc_generator/scripts
COPY Gemfile .
COPY Gemfile.lock .

COPY docs docs

RUN bundle update && bundle config set --local path 'vendor/bundle' && bundle install && ./scripts/doc_generate.sh .

FROM base-image

COPY --from=doc-generator /doc_generator/docs /docs

RUN adduser --uid 2004 --disabled-password --gecos "" docker
COPY target/universal/stage/ /workdir/
RUN chmod +x /workdir/bin/codacy-rubocop
USER docker
WORKDIR /workdir
ENTRYPOINT ["bin/codacy-rubocop"]
