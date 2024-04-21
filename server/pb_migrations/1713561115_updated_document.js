/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("q706vkto9k1axv6")

  // update
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
        "AM",
        "A1",
        "A2",
        "A",
        "B1",
        "B",
        "BE",
        "C1",
        "C1E",
        "C",
        "CE",
        "D1",
        "D1E",
        "D",
        "DE",
        "T"
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
    "id": "ck4pnuvt",
    "name": "driver_license_category",
    "type": "select",
    "required": false,
    "presentable": false,
    "unique": false,
    "options": {
      "maxSelect": 2,
      "values": [
        "A1",
        "B2"
      ]
    }
  }))

  return dao.saveCollection(collection)
})
