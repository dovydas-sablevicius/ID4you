/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // update
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "i3x66qyy",
    "name": "document_code",
    "type": "text",
    "required": false,
    "presentable": false,
    "unique": false,
    "options": {
      "min": null,
      "max": null,
      "pattern": ""
    }
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // update
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "i3x66qyy",
    "name": "document_code",
    "type": "text",
    "required": true,
    "presentable": false,
    "unique": false,
    "options": {
      "min": null,
      "max": null,
      "pattern": ""
    }
  }))

  return dao.saveCollection(collection)
})
