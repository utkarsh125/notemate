# Tables extension

<MavenBadge4 :artifact="'ext-tables'" />

This extension adds support for GFM tables.

```java
final Markwon markwon = Markwon.builder(context)
        // create default instance of TablePlugin
        .usePlugin(TablePlugin.create(context))
        .build();
```

```java
final TableTheme tableTheme = TableTheme.builder()
        .tableBorderColor(Color.RED)
        .tableBorderWidth(0)
        .tableCellPadding(0)
        .tableHeaderRowBackgroundColor(Color.BLACK)
        .tableEvenRowBackgroundColor(Color.GREEN)
        .tableOddRowBackgroundColor(Color.YELLOW)
        .build();

final Markwon markwon = Markwon.builder(context)
        .usePlugin(TablePlugin.create(tableTheme))
        .build();
```

```java
final Markwon markwon = Markwon.builder(context)
        .usePlugin(TablePlugin.create(builder ->
                builder
                        .tableBorderColor(Color.RED)
                        .tableBorderWidth(0)
                        .tableCellPadding(0)
                        .tableHeaderRowBackgroundColor(Color.BLACK)
                        .tableEvenRowBackgroundColor(Color.GREEN)
                        .tableOddRowBackgroundColor(Color.YELLOW)
        .build();
))
```

Please note, that _by default_ tables have limitations. For example, table contents won't be copied to clipboard if a TextView
has such functionality. Table will always take full width of a TextView in which it is displayed.
All columns will always be of the same width. So, _default_ implementation provides basic
functionality which can answer some needs. These all come from the limited nature of the TextView
to display such content.

:::warning
If table contains links a special `MovementMethod` must be used on a `TextView` widget - `TableAwareMovementMethod`,
for example with `MovementMethodPlugin`:
```java
final Markwon markwon = Markwon.builder(context)
  .usePlugin(LinkifyPlugin.create())
  .usePlugin(TablePlugin.create(context))
  // use TableAwareLinkMovementMethod to handle clicks inside tables,
  // wraps LinkMovementMethod internally
  .usePlugin(MovementMethodPlugin.create(TableAwareMovementMethod.create()))
  .build();
```
:::

In order to provide full-fledged experience, tables must be displayed in a special widget.
Since version `3.0.0` Markwon provides a special artifact `markwon-recycler` that allows
to render markdown in a set of widgets in a RecyclerView. It also gives ability to change
display widget form TextView to any other.

```java
final Table table = Table.parse(Markwon, TableBlock);
myTableWidget.setTable(table);
```

:::tip
To take advantage of this functionality and render tables without limitations (including
horizontally scrollable layout when its contents exceed screen width), refer to [recycler-table](/docs/v4/recycler-table/)
module documentation that adds support for rendering `TableBlock` markdown node inside Android-native `TableLayout` widget.
:::

## Theme

### Cell padding

Padding inside a table cell

<ThemeProperty name="tableCellPadding" type="@Px int" defaults="0" />

### Border color

The color of table borders

<ThemeProperty name="tableBorderColor" type="@ColorInt int" defaults="(text color) with 75 (0-255) alpha" />

### Border width

The width of table borders

<ThemeProperty name="tableBorderWidth" type="@Px int" defaults="Stroke with of context TextPaint" />

### Odd row background

Background of an odd table row

<ThemeProperty name="tableOddRowBackgroundColor" type="@ColorInt int" defaults="(text color) with 22 (0-255) alpha" />

### Even row background <Badge text="1.1.1" />

Background of an even table row

<ThemeProperty name="tableEventRowBackgroundColor" type="@ColorInt int" defaults="0" />

### Header row background <Badge text="1.1.1" />

Background of header table row

<ThemeProperty name="tableHeaderRowBackgroundColor" type="@ColorInt int" defaults="0" />
