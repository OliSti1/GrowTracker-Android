package me.anon.grow3.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import me.anon.grow3.di.ApplicationComponent
import kotlin.reflect.KClass

typealias Injector = (ApplicationComponent) -> Unit

public inline fun <reified T : Any> codeOf(): Int = T::class.java.name.hashCode().and(0xffff)
public inline fun <reified T : Any> nameOf(): String = T::class.java.name

public fun <I, O> I.transform(block: I.() -> O): O = block(this)

public fun Any?.toStringOrNull(): String? = this?.toString()?.takeIf { it.isNotBlank() }

public inline fun <reified T: ViewBinding> KClass<ViewBinding>.inflate(container: ViewGroup): T
{
	val viewBinder = this.java.getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
		.invoke(this, LayoutInflater.from(container.context), container, false) as ViewBinding
	return viewBinder as T
}
