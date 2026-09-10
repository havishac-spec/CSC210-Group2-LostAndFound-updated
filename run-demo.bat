@echo off
cd /d "%~dp0"
where python >nul 2>nul
if %errorlevel% neq 0 (
  echo Python was not found. Open index.html directly or use VS Code Live Server.
  pause
  exit /b 1
)
echo Starting Lost ^& Found frontend demo...
echo Open http://localhost:5500 in your browser.
python -m http.server 5500
