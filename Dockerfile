FROM alpine:3.13 as base

RUN apk add --no-cache ruby ruby-etc ruby-dev ruby-irb ruby-rake ruby-io-console \
                       ruby-bigdecimal make gcc ruby-json libstdc++ tzdata bash \
                       ca-certificates libc-dev openjdk8-jre

COPY Gemfile .
COPY Gemfile.lock .

RUN echo 'gem: --no-document' > /etc/gemrc \
    && gem install bundler -v 2.2.7 \
    && bundle install \
    && gem cleanup \
    && rm -rf /tmp/* /var/cache/apk/*

RUN apk --no-cache add openjdk11
COPY docs /docs
RUN adduser --uid 2004 --disabled-password --gecos "" docker
COPY target/universal/stage/ /workdir/
RUN chmod +x /workdir/bin/codacy-rubocop
USER docker
WORKDIR /workdir
ENTRYPOINT ["bin/codacy-rubocop"]
