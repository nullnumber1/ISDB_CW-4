package myfilters

import play.api.http.DefaultHttpFilters

import javax.inject.Inject

class Filters @Inject()(
                         addAccessControlAllowOriginHeaderFilter: AddAccessControlAllowOriginHeaderFilter
                       ) extends DefaultHttpFilters(addAccessControlAllowOriginHeaderFilter)