/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("onktat4z82lb8ws")

  collection.createRule = "@request.auth.collectionName = \"users\""

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("onktat4z82lb8ws")

  collection.createRule = null

  return dao.saveCollection(collection)
})
