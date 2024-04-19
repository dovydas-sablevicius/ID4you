/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // add
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "zywzi0mk",
    "name": "valid_from",
    "type": "date",
    "required": false,
    "presentable": false,
    "unique": false,
    "options": {
      "min": "",
      "max": ""
    }
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // remove
  collection.schema.removeField("zywzi0mk")

  return dao.saveCollection(collection)
})
