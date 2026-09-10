# Frontend Blueprint

## 1. Application goal
A campus Lost & Found platform where users can report lost/found items, search reports, inspect details, track their reports, receive notifications and manage their account.

## 2. Page map
```text
PUBLIC
├── Login
├── Sign Up
└── Forgot Password

AUTHENTICATED
├── Dashboard
├── Browse / Search
│   └── Item Details
├── Report Lost
├── Report Found
├── My Reports
├── Notifications
├── Profile / Settings
└── Help / Guidelines
```

## 3. Page responsibilities
### Login
Email + password; Login; Sign Up; Forgot Password.

### Sign Up
Name, university email, password, confirmation. Student ID/phone can be added later if required.

### Dashboard
Search bar, Report Lost, Report Found, recent lost/found items, active reports and notifications.

### Browse / Search
Keyword search plus type, category, location, date and status filters. Sorting can be newest, oldest or relevance.

### Item Details
Image, title, category, description, location, date, type and status. Possible actions: "I think this is mine", contact/report-owner flow, or resolve.

### Report Lost
Item name, category, description, last-seen location, date/time, identifying features, image(s), contact preference.

### Report Found
Item name, category, description, found location, date/time, identifiable details, image(s), holding location, contact preference.

### My Reports
All / Lost / Found / Resolved tabs. Show item, date, status, possible matches and view/edit actions.

### Notifications
Possible matches, responses, report status changes and claim/request updates.

### Settings
Account, notification preferences, privacy and security.

### Help
Reporting guidance, search guidance, claiming, safety/privacy and dispute guidance.

## 4. Primary navigation
Desktop:
```text
Logo | Dashboard | Browse | Report Lost | Report Found | My Reports | Notifications | Settings
```
Mobile: collapse into a menu.

## 5. Core flows
Lost:
`Login → Dashboard → Report Lost → Submit → Confirmation → Possible Matches → Notifications`

Found:
`Login → Dashboard → Report Found → Submit → Confirmation → Browse / Possible Matches`

Search:
`Dashboard → Search → Filters → Results → Item Details → Possible Match / Contact`

## 6. Required UI states
Every data-driven page should consider:
- Loading
- Success
- Empty
- Error

## 7. Future expansion
Possible later features:
- automatic possible-match suggestions
- claim verification
- admin/moderation dashboard
- report abuse
- campus map
- QR codes
- analytics
- image similarity
- email notifications
