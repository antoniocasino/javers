package org.javers.repository.sql;

import org.javers.repository.sql.schema.FixedSchemaFactory;
import org.javers.repository.sql.schema.JaversSchemaManager;
import org.javers.repository.sql.schema.SchemaNameAware;
import org.javers.repository.sql.schema.TableNameProvider;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Created by antonio on 12/02/2018.
 */
public class CustomSchemaManager extends SchemaNameAware {


    protected CustomSchemaManager() {
        super(new TableNameProvider(Optional.empty()));
    }
}
