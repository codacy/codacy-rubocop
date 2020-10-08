FROM alpine:3.12

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console \
                       ruby-bigdecimal make gcc ruby-json libstdc++ tzdata bash \
                       ca-certificates libc-dev openjdk8-jre

COPY Gemfile .
COPY Gemfile.lock .

RUN echo 'gem: --no-document' > /etc/gemrc \
    && gem install bundler -v 2.1.4 \
    && bundle install \
    && gem cleanup \
    && rm -rf /tmp/* /var/cache/apk/*
