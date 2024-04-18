/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  collection.createRule = "@request.data.Valid:isset = false && @request.auth.id = @request.data.Document_Owner.id"

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  collection.createRule = "@request.data.Valid:isset = false"

  return dao.saveCollection(collection)
})
