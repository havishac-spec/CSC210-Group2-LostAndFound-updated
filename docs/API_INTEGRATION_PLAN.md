# API Integration Plan

The current UI uses mock data. Replace mock operations with calls to the Java backend when the API is finalized.

## Authentication
```text
POST /api/auth/login
POST /api/auth/signup
POST /api/auth/logout
POST /api/auth/forgot-password
```

## Items
```text
GET  /api/items
GET  /api/items/{id}
POST /api/items/lost
POST /api/items/found
PUT  /api/items/{id}
DELETE /api/items/{id}
```

## Search
Conceptually:
```text
GET /api/items/search?q=wallet&type=FOUND&category=Wallet&location=library
```
Possible parameters: `q`, `type`, `category`, `location`, `dateFrom`, `dateTo`, `status`, `sort`.

## User reports
`GET /api/users/me/reports`

## Notifications
```text
GET /api/notifications
PUT /api/notifications/{id}/read
```

## Images
Use `multipart/form-data` or the upload mechanism agreed by the backend/storage team. The final storage provider is intentionally not assumed here.

## Architecture
```text
UI → API/service layer → Java backend → database/storage
```
Keep API calls out of individual visual components wherever possible.
