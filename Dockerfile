FROM openjdk:8-jre-alpine

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console \
                       ruby-bigdecimal make gcc ruby-json libstdc++ tzdata bash \
                       ca-certificates libc-dev

COPY Gemfile .
COPY Gemfile.lock .
COPY .rubocop-version .

RUN echo 'gem: --no-document' > /etc/gemrc \
    && gem install bundler -v 2.0.1 \
    && bundle install \
    && gem cleanup \
    && apk del ruby-dev make gcc \
    && rm -rf /tmp/* /var/cache/apk/*
