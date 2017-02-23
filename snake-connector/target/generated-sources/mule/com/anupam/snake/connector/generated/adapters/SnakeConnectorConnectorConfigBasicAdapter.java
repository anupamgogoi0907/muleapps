
package com.anupam.snake.connector.generated.adapters;

import com.anupam.snake.config.ConnectorConfig;
import com.anupam.snake.connector.SnakeConnector;
import com.anupam.snake.metadata.DataSenseResolver;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.mule.common.DefaultResult;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataFailureType;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.key.property.TypeDescribingProperty;
import org.mule.common.metadata.property.StructureIdentifierMetaDataModelProperty;
import org.mule.devkit.internal.metadata.MetaDataGeneratorUtils;


/**
 * A <code>SnakeConnectorConnectorConfigBasicAdapter</code> is a wrapper around {@link SnakeConnector } that represents the strategy {@link ConnectorConfig }
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-02-23T12:24:52-03:00", comments = "Build UNNAMED.2793.f49b6c7")
public class SnakeConnectorConnectorConfigBasicAdapter
    extends SnakeConnectorProcessAdapter
    implements ConnectorMetaDataEnabled
{


    @Override
    public Result<List<MetaDataKey>> getMetaDataKeys() {
        try {
            List<MetaDataKey> gatheredMetaDataKeys = new ArrayList<MetaDataKey>();
            DataSenseResolver dataSenseResolver = new DataSenseResolver();
            gatheredMetaDataKeys.addAll(MetaDataGeneratorUtils.fillCategory(dataSenseResolver.getMetaDataKeys(), "DataSenseResolver"));
            return new DefaultResult<List<MetaDataKey>>(gatheredMetaDataKeys, (Result.Status.SUCCESS));
        } catch (Exception e) {
            return new DefaultResult<List<MetaDataKey>>(null, (Result.Status.FAILURE), "There was an error retrieving the metadata keys from service provider after acquiring connection, for more detailed information please read the provided stacktrace", MetaDataFailureType.ERROR_METADATA_KEYS_RETRIEVER, e);
        }
    }

    @Override
    public Result<MetaData> getMetaData(MetaDataKey metaDataKey) {
        try {
            MetaData metaData = null;
            TypeDescribingProperty property = metaDataKey.getProperty(TypeDescribingProperty.class);
            String category = ((DefaultMetaDataKey) metaDataKey).getCategory();
            if (category!= null) {
                if (category.equals("DataSenseResolver")) {
                    DataSenseResolver dataSenseResolver = new DataSenseResolver();
                    metaData = dataSenseResolver.getMetaData(metaDataKey);
                } else {
                    throw new Exception(((("Invalid key type. There is no matching category for ["+ metaDataKey.getId())+"]. All keys must contain a category with any of the following options:[DataSenseResolver]")+((", but found ["+ category)+"] instead")));
                }
            } else {
                throw new Exception((("Invalid key type. There is no matching category for ["+ metaDataKey.getId())+"]. All keys must contain a category with any of the following options:[DataSenseResolver]"));
            }
            metaData.getPayload().addProperty(new StructureIdentifierMetaDataModelProperty(metaDataKey, false));
            return new DefaultResult<MetaData>(metaData);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), MetaDataGeneratorUtils.getMetaDataException(metaDataKey), MetaDataFailureType.ERROR_METADATA_RETRIEVER, e);
        }
    }

}
