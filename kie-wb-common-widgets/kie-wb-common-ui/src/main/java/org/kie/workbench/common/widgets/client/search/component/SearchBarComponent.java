/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.workbench.common.widgets.client.search.component;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.jboss.errai.ui.client.local.api.elemental2.IsElement;
import org.kie.workbench.common.widgets.client.search.common.EditorSearchIndex;
import org.kie.workbench.common.widgets.client.search.common.Searchable;
import org.uberfire.client.mvp.UberElemental;

@Dependent
public class SearchBarComponent<T extends Searchable> {

    private final View view;

    private EditorSearchIndex<T> editorSearchIndex;

    @Inject
    public SearchBarComponent(final View view) {
        this.view = view;
    }

    @PostConstruct
    void setup() {
        view.init(this);
    }

    public void init(final EditorSearchIndex<T> editorSearchIndex) {
        this.editorSearchIndex = editorSearchIndex;
    }

    public View getView() {
        return view;
    }

    void search(final String term) {
        if (!term.isEmpty()) {
            editorSearchIndex.search(term);
        }
    }

    public interface View extends UberElemental<SearchBarComponent>,
                                  IsElement {

    }
}
