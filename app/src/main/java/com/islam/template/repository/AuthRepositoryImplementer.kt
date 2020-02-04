package com.islam.template.repository

import com.islam.template.remotedatasource.AuthApi
import javax.inject.Inject

class AuthRepositoryImplementer @Inject constructor(private val remoteAuthApi: AuthApi) : AuthRepository {
    override fun authPostRequest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}