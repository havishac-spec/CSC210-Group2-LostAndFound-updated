# Frontend Application Guidelines

## General
The frontend is the presentation layer. Never put database credentials, passwords, secret keys or backend secrets in frontend files.

## Naming
- lowercase folders
- descriptive filenames
- `camelCase` for JavaScript variables/functions
- `PascalCase` for future React components

## Forms
Every form should have visible labels, required-field validation, useful error/success feedback, and safe duplicate-submission handling. Image inputs should preview the selected image and allow replacement/removal.

## Search
Recommended controls:
- keyword
- Lost / Found
- category
- location
- date range
- sorting

Use one consistent item-card design for search results.

## Navigation
Primary navigation:
- Dashboard
- Browse
- Report Lost
- Report Found
- My Reports
- Notifications
- Settings

## Accessibility
Use semantic HTML, labels, keyboard-accessible controls, meaningful button names, sufficient contrast, and alt text for images. Do not communicate important information by colour alone.

## Responsive design
Support desktop, tablet and mobile. The main navigation should collapse on small screens.

## API integration
Keep API calls in a service/API layer rather than scattering fetch calls throughout UI code.

## Git
Before pushing:
```bash
git status
git add frontend/
git commit -m "Add frontend prototype and documentation"
git push
```
Never commit `.env`, credentials, API secrets or real user data.

## Definition of done
A page is ready when layout, navigation, validation, loading/empty/error states, responsive behaviour and backend integration points have been considered.
