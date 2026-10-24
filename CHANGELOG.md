# Changelog

## 0.8.0

- Choose the exact members to remove when reducing an instance pool with `scale_in_instances`.
- Protect or unprotect pool members with the pool member protection endpoint, and read protection and blocked scale-in status in pool responses.
- Include Email quota policies in quota responses.

Compatibility: quota response models now include `policies` alongside `quotas`; callers constructing these typed responses must supply the new required field.
