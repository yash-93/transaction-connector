package com.ybachhas.transactionConnector;

import org.mule.runtime.extension.api.annotation.Configurations;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;

@Xml(prefix = "transaction-connector")
@Extension(name = "Transaction")
@Configurations(TransactionConfiguration.class)
public class TransactionExtension {

}
