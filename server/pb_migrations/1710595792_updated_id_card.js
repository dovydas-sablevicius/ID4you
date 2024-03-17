/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("onktat4z82lb8ws")

  // update
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "v52mcybg",
    "name": "photos",
    "type": "file",
    "required": true,
    "presentable": false,
    "unique": false,
    "options": {
      "mimeTypes": [
        "image/jpeg",
        "image/png",
        "image/svg+xml",
        "image/gif",
        "image/webp"
      ],
      "thumbs": [],
      "maxSelect": 99,
      "maxSize": 5242880,
      "protected": true
    }
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("onktat4z82lb8ws")

  // update
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "v52mcybg",
    "name": "photos",
    "type": "file",
    "required": false,
    "presentable": false,
    "unique": false,
    "options": {
      "mimeTypes": [
        "image/jpeg",
        "image/png",
        "image/svg+xml",
        "image/gif",
        "image/webp"
      ],
      "thumbs": [],
      "maxSelect": 99,
      "maxSize": 5242880,
      "protected": true
    }
  }))

  return dao.saveCollection(collection)
})
