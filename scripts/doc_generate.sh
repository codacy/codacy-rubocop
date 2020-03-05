DOCS_PATH=$1
rm -rf $DOCS_PATH/docs/description/*
bundle exec doc_generation/rubocop_doc/generator.rb $DOCS_PATH
bundle exec doc_generation/codacy/rubocop/generator.rb $DOCS_PATH
rm -f rubocop-doc.yml
