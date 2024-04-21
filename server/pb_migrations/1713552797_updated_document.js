/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // update
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "bzqxxvb6",
    "name": "type",
    "type": "select",
    "required": true,
    "presentable": false,
    "unique": false,
    "options": {
      "maxSelect": 1,
      "values": [
        "Identity Card",
        "Passport",
        "Student Card",
        "Driver License"
      ]
    }
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // update
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "bzqxxvb6",
    "name": "type",
    "type": "select",
    "required": true,
    "presentable": false,
    "unique": false,
    "options": {
      "maxSelect": 1,
      "values": [
        "Identity Card",
        "Passport",
        "Student Card"
      ]
    }
  }))

  return dao.saveCollection(collection)
})
