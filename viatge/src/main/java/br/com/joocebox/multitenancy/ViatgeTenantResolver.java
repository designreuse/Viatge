package br.com.joocebox.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.joocebox.model.Agency;
import br.com.joocebox.repositories.AgencyRepository;

public class ViatgeTenantResolver implements CurrentTenantResolver<Long> {

	private static String MASTER_TENANT_SUBDOMAIN = "www";

	@Autowired
	private AgencyRepository agencyRepository;

	protected Long getCurrentTenantFromSubdomain() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String subdomain = attr.getRequest().getServerName().split("\\.")[0];

		Agency agency = agencyRepository.getBySubdomain(subdomain);
		return agency != null ? agency.getTenantId() : 0;
	}

	@Override
	public Long getCurrentTenantId() {
		return getCurrentTenantFromSubdomain();
	}

	@Override
	public Long getMasterTenantId() {
		return agencyRepository.getBySubdomain(MASTER_TENANT_SUBDOMAIN)
				.getTenantId();
		
	}

	@Override
	public boolean isMasterTenant() {
		Long masterTenant = getMasterTenantId();
		Long tenantFromSubdomain = getCurrentTenantFromSubdomain();

		return masterTenant.equals(tenantFromSubdomain);
	}

	@Override
	public boolean isSubDomainExist() {
		if (getCurrentTenantFromSubdomain() != 0) {
			return true;
		} else {
			return false;
		}
		
	}
}
