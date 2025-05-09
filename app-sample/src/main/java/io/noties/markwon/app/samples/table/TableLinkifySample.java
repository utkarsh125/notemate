package io.noties.markwon.app.samples.table;

import io.noties.markwon.Markwon;
import io.noties.markwon.app.sample.ui.MarkwonTextViewSample;
import io.noties.markwon.ext.tables.TableAwareMovementMethod;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.linkify.LinkifyPlugin;
import io.noties.markwon.movement.MovementMethodPlugin;
import io.noties.markwon.sample.annotations.MarkwonArtifact;
import io.noties.markwon.sample.annotations.MarkwonSampleInfo;
import io.noties.markwon.sample.annotations.Tag;

@MarkwonSampleInfo(
  id = "20200702135739",
  title = "Linkify table",
  description = "Automatically linkify markdown content " +
    "including content inside tables, handle clicks inside tables",
  artifacts = {MarkwonArtifact.EXT_TABLES, MarkwonArtifact.LINKIFY},
  tags = {Tag.links}
)
public class TableLinkifySample extends MarkwonTextViewSample {
  @Override
  public void render() {
    final String md = "" +
      "| HEADER | HEADER | HEADER |\n" +
      "|:----:|:----:|:----:|\n" +
      "|   测试  |   测试   |   测试   |\n" +
      "|   测试  |   测试   |  测测测12345试测试测试   |\n" +
      "|   测试  |   测试   |   123445   |\n" +
      "|   测试  |   测试   |   (650) 555-1212   |\n" +
      "|   测试  |   测试   |   mail@ma.il   |\n" +
      "|   测试  |   测试   |   some text that goes here is very very very very important [link](https://noties.io/Markwon)   |\n" +
      "\n" +
      "测试\n" +
      "\n" +
      "[link link](https://link.link)";

    final Markwon markwon = Markwon.builder(context)
      .usePlugin(LinkifyPlugin.create())
      .usePlugin(TablePlugin.create(context))
      // use TableAwareLinkMovementMethod to handle clicks inside tables
      .usePlugin(MovementMethodPlugin.create(TableAwareMovementMethod.create()))
      .build();

    markwon.setMarkdown(textView, md);
  }
}
