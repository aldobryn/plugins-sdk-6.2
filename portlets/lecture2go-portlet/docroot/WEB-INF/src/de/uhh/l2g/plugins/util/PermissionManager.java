package de.uhh.l2g.plugins.util;
/***************************************************************************
 * The Lecture2Go software is based on the liferay portal 6.1.1
 * <http://www.liferay.com>
 *
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 *
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 *
 * @Autor Lecture2Go Team
 * @Version 1.0
 * @Contact lecture2go-open-source@uni-hamburg.de
 *
 * Copyright (c) 2013 University of Hamburg / Computer and Data Center (RRZ)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ***************************************************************************/

import java.util.List;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortletKeys;



public class PermissionManager {
	
private ServiceContext context;


     public PermissionManager(ServiceContext serviceContext) {
    	 
    	 context = serviceContext;
	
     }
     
     public PermissionManager(PortletRequest portletRequest, String className) {
    	 
 	    ServiceContext serviceContext = null;
		
			try {
				serviceContext = ServiceContextFactory.getInstance(
					         className, portletRequest);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			context = serviceContext;	
     }
     
     /**Generate ServiceContext from Plid, PortletId and User 
      * 
      * If ServiceContext is not retrieved from Request we have no PortletId
      * 
      * @param plid - LayoutId
      * @param pId - portletId
      * @param u
      * @throws PortalException
      * @throws SystemException
      */
     public PermissionManager(Long plid, User u) throws PortalException, SystemException{
    	 
    	 Layout layout = null;
    	 try {
			layout  = LayoutLocalServiceUtil.fetchLayout(plid);
		 } catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
    	 
    	 ServiceContext serviceContext = new ServiceContext();
    	 
    	 //Data from Layout
    	 serviceContext.setScopeGroupId(layout.getGroupId());
    	 serviceContext.setCompanyId(layout.getCompanyId());
    	 serviceContext.setPlid(layout.getPlid());
    	    	   
    	 //Data from User
    	 serviceContext.setUserId(u.getUserId());
    	 	 
    	 context = serviceContext;
     }
     
     
     /**Grant Permission on Portlet to Role (Model/Group)
 	 * 
 	 * @param roleName
 	 * @param entityName
 	 * @param entityName
 	 * @param serviceContext
 	 * @throws SystemException
 	 * @throws PortalException
 	 */
 	public void setL2GEntityPermissions(String roleName, String entityName, String action) throws SystemException, PortalException {
 	
 	    try{
 	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
 			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), new String[] {action});
 	
 		} catch (PortalException e) {
 			System.out.println("Could not set Permission for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")");
 			e.printStackTrace();
 		}
 					
 	}	
 	
	/**Grant Permissions on Portlet to Role (Model/Group)
	 * 
	 * @param roleName
	 * @param entityName
	 * @param entityName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GEntityPermissions(String roleName, String entityName, String[] actions) throws SystemException, PortalException {
	
	    try{
	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions);
	
		} catch (PortalException e) {
			System.out.println("Could not set Permissions for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
					
	}	
	
	
	/**Remove Permissions on Portlet to Role (Model/Group)
	 * 
	 * @param roleName
	 * @param entityName
	 * @param entityName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GEntityPermissions(String roleName, String entityName, String action) throws SystemException, PortalException {
	
	    try{
	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
	    	
		
		    ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), action);
		
	
		} catch (PortalException e) {
			System.out.println("Could not remove Permissions for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
					
	}
	/**Remove Permissions on Portlet to Role (Model/Group)
	 * 
	 * @param roleName
	 * @param entityName
	 * @param entityName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GEntityPermissions(String roleName, String entityName, String[] actions) throws SystemException, PortalException {
	
	    try{
	    	Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
	    	
			for (int i=0; i<actions.length;i++){
				ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), entityName, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions[i]);
			}
	
		} catch (PortalException e) {
			System.out.println("Could not remove Permissions for "+roleName+" on entity "+entityName+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
					
	}
	
	
	/**Grant Permissions on calling Portlet to Role 
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GPortletPermissions(String roleName, String action) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
		
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), new String[] {action});
		
		} catch (PortalException e) {
			System.out.println("Could not set Permission for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
	}
	
	
	/**Grant Permissions on calling Portlet to Role 
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GPortletPermissions(String roleName,  String[] actions) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
		
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions);
		
		} catch (PortalException e) {
			System.out.println("Could not set Permissions for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
	}
	
	
	/**Remove Permissions on calling Portlet to Role (Portlet/Group)
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GPortletPermissions(String roleName,  String action) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
			ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), action);

		
		} catch (PortalException e) {
			System.out.println("Could not remove Permissions for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
	}
	
	/**Remove Permissions on calling Portlet to Role (Portlet/Group)
	 * 
	 * @param roleName
	 * @param actions
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GPortletPermissions(String roleName,  String[] actions) throws SystemException, PortalException{
		
		String pId = context.getPortletId();
		if (context.getPortletId().equals("")) pId = getL2GPortletByPlid(context.getPlid());
		try{
			
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);	
			for (int i=0; i<actions.length;i++){
				ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), pId, ResourceConstants.SCOPE_GROUP, String.valueOf(context.getScopeGroupId()), role.getRoleId(), actions[i]);
			}
		
		} catch (PortalException e) {
			System.out.println("Could not remove Permissions for "+roleName+" on Portlet "+ pId+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
	}
	
	/**Grant Page View Permission to Role (Layout/Individual)
	 * 
	 * @param roleName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GLayoutViewPermission(String roleName) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), new String[] {ActionKeys.VIEW});			
		
		} catch (PortalException e) {
			System.out.println("Could not set View Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}	
	}
	
	/**Remove Page View Permission to Role (Layout/Individual)
	 * 
	 * @param roleName
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void removeL2GLayoutViewPermission(String roleName) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), ActionKeys.VIEW);
				
		} catch (PortalException e) {
			System.out.println("Could not remove View Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}	
	}
	
	
	/**Add Permission on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GLayoutPermissions(String roleName, String action) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), new String[] {action});			
		
		} catch (PortalException e) {
			System.out.println("Could not set Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}	
	 }
	
	
	/**Add Permissions on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void setL2GLayoutPermissions(String roleName, String[] actions) throws SystemException, PortalException{
		
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);		
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), actions);			
		
		} catch (PortalException e) {
			System.out.println("Could not set Permissions for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}	
	 }
	
	
	/**Remove Permission on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void removeL2GLayoutPermissions(String roleName, String action) throws PortalException, SystemException{
		       
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);
			ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), action);
		
		} catch (PortalException e) {
			System.out.println("Could not remove Permissions for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
	}
	/**Remove Permissions on Layout/Individual
	 * 
	 * @param roleName
	 * @param actions
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void removeL2GLayoutPermissions(String roleName, String[] actions) throws PortalException, SystemException{
		try{
			Role role = RoleLocalServiceUtil.getRole(context.getCompanyId(), roleName);
		
			for (int i=0; i<actions.length;i++){
				ResourcePermissionLocalServiceUtil.removeResourcePermission(context.getCompanyId(), "com.liferay.portal.model.Layout", ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(context.getPlid()), role.getRoleId(), actions[i]);
			}		
		} catch (PortalException e) {
			System.out.println("Could not remove Permission for "+roleName+" on Page "+ context.getLayoutURL()+". ("+context.getGuestOrUserId()+")");
			e.printStackTrace();
		}
	}
	
    /**Get L2G Portlet by Layout (expects only one L2G portlet per page)
     * 
     * @param plid
     * @throws SystemException 
     */
	public String getL2GPortletByPlid(long plid) throws SystemException{ 
		String portletId ="";
		long ownerId = 0;
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;
	    List<PortletPreferences> pPrefs = PortletPreferencesLocalServiceUtil.getPortletPreferences(ownerId, ownerType, plid);
	    
	    int i = 0;
	    
	    while (i < pPrefs.size() && portletId.equals("") ){
	    	PortletPreferences p = pPrefs.get(i);
	    	if (p.getPortletId().startsWith("lg")) portletId = p.getPortletId();
	     i++;
	    }	
	    
	    return portletId;
	    
	}
	

}
