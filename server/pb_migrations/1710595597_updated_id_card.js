/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("onktat4z82lb8ws")

  collection.listRule = "@request.auth.id = user_relation.id"

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("onktat4z82lb8ws")

  collection.listRule = null

  return dao.saveCollection(collection)
})
