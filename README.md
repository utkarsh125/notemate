# NoteMate

**NoteMate** is a markdown-powered note-taking Android app. It parses markdown
following [commonmark-spec] with the help of the [commonmark-java]
library and renders results as _Android-native_ Spannables. **No HTML**
is involved as an intermediate step. **No WebView** is required.
It's fast, feature-rich, and highly extensible.

It allows markdown rendering in all `TextView` widgets
(`TextView`, `Button`, `Switch`, `CheckBox`, etc), toasts, and any view
that supports `Spanned` content. Default styles are provided but
can be fully customized. All markdown features from [commonmark-spec] are supported,
including tables and syntax highlighting.

`NoteMate` is built to support both read and write markdown flows, including
live preview in `EditText` using the [editor](./markwon-editor/) module.

[commonmark-spec]: https://spec.commonmark.org/0.28/
[commonmark-java]: https://github.com/atlassian/commonmark-java/blob/master/README.md

---
