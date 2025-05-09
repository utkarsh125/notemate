package io.noties.markwon.app.samples.editor;

import io.noties.markwon.Markwon;
import io.noties.markwon.app.samples.editor.shared.MarkwonEditTextSample;
import io.noties.markwon.editor.MarkwonEditor;
import io.noties.markwon.editor.MarkwonEditorTextWatcher;
import io.noties.markwon.sample.annotations.MarkwonArtifact;
import io.noties.markwon.sample.annotations.MarkwonSampleInfo;
import io.noties.markwon.sample.annotations.Tag;

@MarkwonSampleInfo(
  id = "20200629164227",
  title = "Simple editor",
  description = "Simple usage of editor with markdown highlight",
  artifacts = {MarkwonArtifact.EDITOR, MarkwonArtifact.INLINE_PARSER},
  tags = {Tag.editor}
)
public class EditorSimpleSample extends MarkwonEditTextSample {
  @Override
  public void render() {
    // Process highlight in-place (right after text has changed)

    // obtain Markwon instance
    final Markwon markwon = Markwon.create(context);

    // create editor
    final MarkwonEditor editor = MarkwonEditor.create(markwon);

    // set edit listener
    editText.addTextChangedListener(MarkwonEditorTextWatcher.withProcess(editor));
  }
}
