package com.malotian.shibboleth.idp.consent.flow.ar.impl;

import javax.annotation.Nonnull;

import org.opensaml.profile.context.ProfileRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.shibboleth.idp.profile.AbstractProfileAction;

public class ReleaseAttributesPostProcessor extends AbstractProfileAction {

	private final Logger logger = LoggerFactory.getLogger(ReleaseAttributesPostProcessor.class);

	@Override
	protected void doExecute(@Nonnull final ProfileRequestContext profileRequestContext) {
		logger.info("------------------------ReleaseAttributesPostProcessor");
	}
}