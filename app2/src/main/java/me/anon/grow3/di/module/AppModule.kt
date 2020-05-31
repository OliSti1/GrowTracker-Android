package me.anon.grow3.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.anon.grow3.data.repository.DiariesRepository
import me.anon.grow3.data.repository.impl.DefaultDiariesRepository
import me.anon.grow3.data.source.DiariesDataSource
import me.anon.grow3.data.source.nitrite.NitriteDiariesDataSource
import me.anon.grow3.util.application
import javax.inject.Named

@Module
class AppModule(
	private val appContext: Context
)
{
	@Provides public fun provideAppContext() = appContext.applicationContext

	@Provides
	@Named("garden_source")
	public fun provideGardenSource(): String = appContext.application.dataPath + "/diaries.db"

	@Provides
	public fun provideGardenDataSource(dataSource: NitriteDiariesDataSource): DiariesDataSource = dataSource

	@Provides
	public fun provideGardenRepository(repo: DefaultDiariesRepository): DiariesRepository = repo
}
