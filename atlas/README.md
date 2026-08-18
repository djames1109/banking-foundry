# Atlas

A reusable banking platform responsible for customer, account, card, and card-transaction capabilities.

Atlas is divided into independently deployable services:

- `atlas-account` — Customer and account information.
- `atlas-card` — Card information and card-related operations.
- `atlas-transaction` — Card-side financial transactions, including transaction posting and reversal.

Atlas represents the card/account processing platform and can be reused by multiple Banking Foundry applications.
