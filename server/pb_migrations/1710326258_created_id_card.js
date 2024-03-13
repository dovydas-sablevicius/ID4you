/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "onktat4z82lb8ws",
    "created": "2024-03-13 10:37:38.568Z",
    "updated": "2024-03-13 10:37:38.568Z",
    "name": "id_card",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "ttnkrv90",
        "name": "name",
        "type": "text",
        "required": false,
        "presentable": false,
        "unique": false,
        "options": {
          "min": null,
          "max": null,
          "pattern": ""
        }
      },
      {
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
      },
      {
        "system": false,
        "id": "diaryywc",
        "name": "user_relation",
        "type": "relation",
        "required": true,
        "presentable": false,
        "unique": false,
        "options": {
          "collectionId": "_pb_users_auth_",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": 1,
          "displayFields": null
        }
      }
    ],
    "indexes": [],
    "listRule": null,
    "viewRule": null,
    "createRule": null,
    "updateRule": null,
    "deleteRule": null,
    "options": {}
  });

  return Dao(db).saveCollection(collection);
}, (db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("onktat4z82lb8ws");

  return dao.deleteCollection(collection);
})
