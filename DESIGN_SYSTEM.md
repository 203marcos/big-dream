# Big Dream - Design System

This document defines the visual standards for the Big Dream app. Follow these rules when building new screens or components to keep the UI consistent.

---

## Colors

We use a **semantic color token** system. Never hardcode hex values in screens — always reference `MaterialTheme.colorScheme`.

### Light Theme

| Token | Hex | Usage |
|-------|-----|-------|
| `primary` | `#2563EB` (Blue 600) | Primary buttons, links, active states |
| `onPrimary` | `#FFFFFF` | Text/icons on primary color |
| `primaryContainer` | `#EFF6FF` (Blue 50) | Avatar backgrounds, subtle highlights |
| `onPrimaryContainer` | `#1D4ED8` (Blue 700) | Text on primary container |
| `secondary` | `#475569` (Slate 600) | Secondary actions, labels |
| `secondaryContainer` | `#F1F5F9` (Slate 100) | Chips, tags, secondary surfaces |
| `tertiary` | `#F97316` (Orange 500) | CTAs, accent highlights |
| `background` | `#F8FAFC` (Slate 50) | Page background |
| `surface` | `#FFFFFF` | Cards, bottom bar, top bar |
| `surfaceVariant` | `#F1F5F9` (Slate 100) | Alternative surfaces |
| `onSurface` | `#1E293B` (Slate 800) | Primary text |
| `onSurfaceVariant` | `#475569` (Slate 600) | Secondary text, captions |
| `outline` | `#CBD5E1` (Slate 300) | Borders, input outlines |
| `outlineVariant` | `#E2E8F0` (Slate 200) | Dividers, subtle borders |
| `error` | `#DC2626` | Error states |
| `errorContainer` | `#FEE2E2` | Error background |

### Dark Theme

Uses desaturated/lighter tonal variants — not simple inversion. Key changes:
- `primary` becomes `#60A5FA` (Blue 400) for readability on dark surfaces
- `background` becomes `#0F172A` (Slate 900)
- `surface` becomes `#1E293B` (Slate 800)
- Text colors shift to `Slate 100` / `Slate 300`

### Semantic Colors (for Status)

| Color | Hex | Usage |
|-------|-----|-------|
| Success | `#16A34A` | Confirmation, connected states |
| Error | `#DC2626` | Errors, destructive actions |
| Warning | `#D97706` | Caution states |
| Info | `#0EA5E9` | Informational messages |

---

## Typography

We use **Poppins** for headings and **Open Sans** for body text, loaded via Google Fonts.

### Type Scale

| Style | Font | Weight | Size | Line Height | Usage |
|-------|------|--------|------|-------------|-------|
| `displayLarge` | Poppins | Bold | 57sp | 64sp | Hero text (rare) |
| `displayMedium` | Poppins | Bold | 45sp | 52sp | Large hero text |
| `displaySmall` | Poppins | SemiBold | 36sp | 44sp | Section heroes |
| `headlineLarge` | Poppins | SemiBold | 32sp | 40sp | Screen titles (Login, Register) |
| `headlineMedium` | Poppins | SemiBold | 28sp | 36sp | Section headers |
| `headlineSmall` | Poppins | SemiBold | 24sp | 32sp | Card titles, profile name |
| `titleLarge` | Poppins | Medium | 22sp | 28sp | Top app bar titles |
| `titleMedium` | Poppins | Medium | 16sp | 24sp | Card subtitles, stats |
| `titleSmall` | Poppins | Medium | 14sp | 20sp | List item names, small titles |
| `bodyLarge` | Open Sans | Normal | 16sp | 24sp | Main body text, descriptions |
| `bodyMedium` | Open Sans | Normal | 14sp | 20sp | Secondary body text, post content |
| `bodySmall` | Open Sans | Normal | 12sp | 16sp | Captions, headlines under names |
| `labelLarge` | Open Sans | Medium | 14sp | 20sp | Button text |
| `labelMedium` | Open Sans | Medium | 12sp | 16sp | Chip labels, small buttons |
| `labelSmall` | Open Sans | Medium | 11sp | 16sp | Timestamps, engagement counts |

### Rules
- Always use `MaterialTheme.typography.*` — never set font size directly
- Headings use `fontWeight = FontWeight.SemiBold` by default
- Body text uses regular weight; use `FontWeight.Medium` for emphasis only
- Minimum text size: 11sp (labelSmall) for timestamps; 12sp for readable content

---

## Spacing

We follow an **8dp grid system** with a 4dp sub-grid for fine adjustments.

### Scale

| Token | Value | Usage |
|-------|-------|-------|
| `xs` | 4.dp | Inner padding for tight elements |
| `sm` | 8.dp | Gap between related items, card inner spacing |
| `md` | 12.dp | Between form fields, list items vertical padding |
| `lg` | 16.dp | Card padding, section padding |
| `xl` | 24.dp | Screen horizontal padding, section gaps |
| `2xl` | 32.dp | Between major sections |
| `3xl` | 48.dp | Screen top/bottom safe spacing |

### Rules
- Screen horizontal padding: **24.dp**
- Card internal padding: **16.dp**
- Space between form fields: **12.dp**
- Space between a label group and its action button: **24.dp**
- Vertical arrangement between cards: **8.dp**
- Use `Spacer(modifier = Modifier.height(Xdp))` for explicit vertical spacing

---

## Shapes (Corner Radius)

| Shape | Radius | Usage |
|-------|--------|-------|
| `extraSmall` | 4.dp | Full-width cards (feed posts, connection items) |
| `small` | 8.dp | Buttons, text fields, small cards |
| `medium` | 12.dp | Dialogs, banners, image containers |
| `large` | 16.dp | Bottom sheets, large cards |
| `extraLarge` | 24.dp | Full-screen modals |
| `CircleShape` | 50% | Avatars, icon containers |

### Rules
- Always use `MaterialTheme.shapes.*` — never hardcode corner radius
- Buttons and text fields: `MaterialTheme.shapes.small`
- Full-width list cards: `MaterialTheme.shapes.extraSmall`

---

## Components

### Cards
- Use `CardDefaults.cardElevation(defaultElevation = 0.dp)` — flat cards with color separation
- Container color: `MaterialTheme.colorScheme.surface`
- Full-width cards use `shapes.extraSmall` (minimal rounding)

### Buttons
- **Primary**: `Button` with `containerColor = primary`, `shape = shapes.small`
- **Secondary/Outline**: `OutlinedButton` with `shape = shapes.small`
- **Text**: `TextButton` for navigation links
- Min height: **48.dp** for primary actions (meets touch target requirements)

### Text Fields
- Use `OutlinedTextField` with `shape = MaterialTheme.shapes.small`
- Always include a `label` — never use placeholder-only
- Password fields must have a show/hide toggle (`trailingIcon`)

### Avatars
- Size: **48.dp** in lists, **96.dp** on profile
- Shape: `CircleShape`
- Background: `primaryContainer`
- Text: First letter of name, `titleMedium`, `primary` color

### Bottom Navigation
- Max **3-5 items** with icon + label
- Use filled icons for selected, outlined for unselected
- `containerColor = surface`, `tonalElevation = 0.dp`
- Selected color: `primary`, unselected: `onSurfaceVariant`
- Indicator: `primaryContainer`

### Top App Bar
- `containerColor = surface`
- Title: `titleLarge` with `FontWeight.SemiBold`
- Brand title (Feed screen): colored with `primary`

### Dividers
- Use `HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)`

---

## Accessibility

- Text contrast must be **4.5:1** minimum (our palette meets this)
- All icons must have `contentDescription`
- Touch targets: minimum **48.dp** (buttons), **44.dp** (icon buttons)
- Use `PasswordVisualTransformation` toggle for password fields
- Labels on all form inputs (no placeholder-only)
- Support system dark mode via `isSystemInDarkTheme()`

---

## File Structure

```
presentation/ui/theme/
├── Color.kt     — Color definitions (semantic palette)
├── Type.kt      — Typography (Poppins + Open Sans, type scale)
├── Shape.kt     — Shape definitions (corner radius)
└── Theme.kt     — BigDreamTheme composable (wires color + type + shape)
```

When adding new colors, add them to `Color.kt` and reference them in `Theme.kt` color schemes. Never use raw `Color(0xFF...)` in screen files.
