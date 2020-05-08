package com.malotian.shibboleth.idp.consent.flow.ar.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import org.opensaml.profile.context.ProfileRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.shibboleth.idp.attribute.IdPAttribute;
import net.shibboleth.idp.attribute.IdPAttributeValue;
import net.shibboleth.idp.attribute.StringAttributeValue;
import net.shibboleth.idp.attribute.context.AttributeContext;
import net.shibboleth.idp.consent.flow.ar.impl.AbstractAttributeReleaseAction;
import net.shibboleth.idp.profile.context.ProfileInterceptorContext;

public class ReleaseAttributesPostProcessor extends AbstractAttributeReleaseAction {

	private final Logger logger = LoggerFactory.getLogger(ReleaseAttributesPostProcessor.class);

	@Override
	protected void doExecute(@Nonnull final ProfileRequestContext profileRequestContext, @Nonnull final ProfileInterceptorContext interceptorContext) {
		logger.info("------------------------OutboundMessageProcessor");

		AttributeContext attributeContext = getAttributeContext();
		for (String attr : attributeContext.getIdPAttributes().keySet()) {
			logger.info("------------------------attr: {}", attr);
		}

		final Map<String, IdPAttribute> attributes = new HashMap<String, IdPAttribute>();
		attributes.putAll(attributeContext.getIdPAttributes());
		attributes.remove("givenName");
		attributes.get("surname").setValues(new ArrayList<IdPAttributeValue>(Arrays.asList(new StringAttributeValue("Dhanjal"))));
		getAttributeContext().setIdPAttributes(attributes.values());
	}
}