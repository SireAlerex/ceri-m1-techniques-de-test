FILE="$1"

if grep -q 'severity="error"' "$FILE"; then
  COUNT="$(grep 'severity="warning"' "$FILE" | wc -l)"
  curl -o checkstyle-badge.svg "https://img.shields.io/badge/checkstyle-${COUNT}_errors-red.svg"
  exit 0
fi

if grep -q 'severity="warning"' "$FILE"; then
  COUNT="$(grep 'severity="warning"' "$FILE" | wc -l)"
  curl -o checkstyle-badge.svg "https://img.shields.io/badge/checkstyle-${COUNT}_warnings-orange.svg"
  exit 0
fi

curl -o checkstyle-badge.svg "https://img.shields.io/badge/checkstyle-ok-green.svg"
exit 0