
<#if views??>
<#-- Loop over all views that need updating / adding / deleting -->
<#list views as view>

<#if (version < (view.fromModuleVersion)!0) || mode == "create">

-- current version ${version}
-- upgrade from version ${(view.fromModuleVersion)!0}

  <#if view.mode != "delete">
    <#include "create_view.ftl">
  <#else>
    DROP VIEW IF EXISTS ${myuniversity}_${mymodule}.${table.tableName} CASCADE;
  </#if>
  
</#if>

</#list>

</#if>