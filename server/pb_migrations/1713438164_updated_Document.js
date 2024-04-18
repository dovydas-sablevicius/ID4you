/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  collection.listRule = "@request.auth.id = Document_Owner.id"
  collection.viewRule = "@request.auth.id = Document_Owner.id"

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  collection.listRule = null
  collection.viewRule = null

  return dao.saveCollection(collection)
})
