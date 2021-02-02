#!/usr/bin/env bash

DOCS_PATH=$1
rm -rf $DOCS_PATH/docs/description/*
mkdir -p "$DOCS_PATH/docs/description"
if [ ! -d "vendor" ]; then # ensure bundle is installed
    bundle install --path vendor/bundle
fi
bundle exec doc_generation/rubocop_doc/generator.rb $DOCS_PATH
bundle exec doc_generation/codacy/rubocop/generator.rb $DOCS_PATH
rm -f rubocop-doc.yml
