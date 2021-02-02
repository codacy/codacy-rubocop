##Patterns: Style_MultilineBlockChain

Thread.list.find_all do |t|
  t.alive?
  ##Info: Style_MultilineBlockChain
end.map do |t|
  t.object_id
end
