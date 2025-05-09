package io.noties.markwon.app.samples;

import androidx.annotation.NonNull;

import org.commonmark.node.Heading;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.Markwon;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.app.sample.ui.MarkwonTextViewSample;
import io.noties.markwon.sample.annotations.MarkwonArtifact;
import io.noties.markwon.sample.annotations.MarkwonSampleInfo;
import io.noties.markwon.sample.annotations.Tag;

@MarkwonSampleInfo(
  id = "20200629123308",
  title = "Disable node from rendering",
  description = "Disable _parsed_ node from being rendered (markdown syntax is still consumed)",
  artifacts = {MarkwonArtifact.CORE},
  tags = {Tag.parsing, Tag.rendering}
)
public class DisableNodeSample extends MarkwonTextViewSample {
  @Override
  public void render() {
    final String md = "# Heading 1\n\n## Heading 2\n\n**other** content [here](#)";

    final Markwon markwon = Markwon.builder(context)
      .usePlugin(new AbstractMarkwonPlugin() {
        @Override
        public void configureVisitor(@NonNull MarkwonVisitor.Builder builder) {

          // for example to disable rendering of heading:
          // try commenting this out to see that otherwise headings will be rendered
          builder.on(Heading.class, null);

          // same method can be used to override existing visitor by specifying
          // a new NodeVisitor instance
        }
      })
      .build();

    markwon.setMarkdown(textView, md);
  }
}
