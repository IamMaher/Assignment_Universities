package com.example.list.di

import com.example.di.CoreComponent
import com.example.di.scope.FeatureScope
import com.example.list.presentation.view.ListFragment
import dagger.Component

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [
        ListModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface ListComponent {
    fun inject(listFragment: ListFragment)
}
