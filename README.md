# Lost & Found — Frontend

> Frontend prototype for the DSA Lost & Found project. Product name is intentionally left as **Lost & Found** until the team finalizes branding.

## Purpose
This folder contains the frontend direction, documentation, and a working browser-based prototype.

Current prototype: **HTML5 + CSS3 + Vanilla JavaScript**, with local mock data. No backend or npm installation is required.

## Demo includes
- Login / Sign up
- Dashboard
- Browse & Search
- Lost / Found filters
- Report Lost
- Report Found
- Image upload preview
- Item details
- My Reports
- Notifications
- Settings
- Help / Guidelines
- Responsive navigation
- Demo logout

## Run locally
### VS Code
1. Open this `frontend` folder in VS Code.
2. Open `index.html`.
3. Use Live Server if installed.

### Python
From this folder:
```bash
python -m http.server 5500
```
Then open `http://localhost:5500`.

## Demo login
Any email/password combination works in demo mode.
Example: `student@ahduni.edu.in` / `demo123`

Authentication is simulated locally and is **not connected to a real database**.

## Folder structure
```text
frontend/
├── index.html
├── README.md
├── APPLICATION_GUIDELINES.md
├── .gitignore
├── css/styles.css
├── js/app.js
├── assets/
└── docs/
    ├── FRONTEND_BLUEPRINT.md
    ├── DESIGN_SYSTEM.md
    ├── COMPONENTS.md
    ├── FOLDER_STRUCTURE.md
    ├── API_INTEGRATION_PLAN.md
    └── UX_FLOW.md
```

## Backend integration
The Java backend should eventually provide authentication, users, lost/found reports, image storage, search/retrieval, notifications, matching and claims. See `docs/API_INTEGRATION_PLAN.md`.

## Design principle
The three core actions should always be obvious:
- **Find something → Search/Browse**
- **Lost something → Report Lost**
- **Found something → Report Found**
