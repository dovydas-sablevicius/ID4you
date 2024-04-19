/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // add
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "ck4pnuvt",
    "name": "driver_license_category",
    "type": "select",
    "required": false,
    "presentable": false,
    "unique": false,
    "options": {
      "maxSelect": 2,
      "values": [
        "A",
        "B",
        "C"
      ]
    }
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // remove
  collection.schema.removeField("ck4pnuvt")

  return dao.saveCollection(collection)
})
