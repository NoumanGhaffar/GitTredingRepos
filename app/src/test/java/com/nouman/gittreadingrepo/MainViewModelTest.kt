package com.nouman.gittreadingrepo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nouman.gittreadingrepo.models.Repo
import com.nouman.gittreadingrepo.models.RepoOwner
import com.nouman.gittreadingrepo.models.TrendingRepos
import com.nouman.gittreadingrepo.repos.GitRepository
import com.nouman.gittreadingrepo.viewmodel.MainViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.*
import org.junit.runners.*

@RunWith(JUnit4::class)
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var gitRepository: GitRepository
    @Before
    @ExperimentalCoroutinesApi
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(TestCoroutineDispatcher())
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun whenGetAllTreadingReposCalled_andSomeDataExist_observersShouldInvokedAndReturnRequiredResults() {
        runBlocking {
            val observer = mockk<Observer<TrendingRepos>>(relaxed = true)
            coEvery { gitRepository.getTrendingRepos() } returns getDummyData(false)
            val viewModel = MainViewModel(gitRepository)
            viewModel.getTrendingRepos().observeForever(observer)
            viewModel.getTrendingReposFromServer()
            verify { observer.onChanged(match { it!= null && it.repoList.size ==5 }) }
        }
    }
    @Test
    fun whenGetAllTreadingReposCalled_andNoDataExist_observersShouldInvokedAndReturnRequiredResults() {
        runBlocking {
            val observer = mockk<Observer<TrendingRepos>>(relaxed = true)
            coEvery { gitRepository.getTrendingRepos() } returns getDummyData(true)
            val viewModel = MainViewModel(gitRepository)
            viewModel.getTrendingRepos().observeForever(observer)
            viewModel.getTrendingReposFromServer()
            verify { observer.onChanged(match { it!= null && it.repoList.isEmpty() }) }
        }
    }


    private fun getDummyData(sendEmpty: Boolean) : TrendingRepos{
        return if (!sendEmpty)
            TrendingRepos(100,getRepoList())
        else
            TrendingRepos(0, emptyList())
    }

    private fun getRepoList(): List<Repo> {
        val repoList = mutableListOf<Repo>()
        repoList.add(
            Repo(100,"0000001","TestRpo1",
            "This is first test repo","java", 30, RepoOwner("test1",1,"www.test1.com")
            )
        )
        repoList.add(
            Repo(200,"0000002","TestRpo2",
                "This is second test repo","java", 30, RepoOwner("test2",2,"www.test2.com")
            )
        )
        repoList.add(
            Repo(300,"0000003","TestRpo3",
                "This is third test repo","java", 30, RepoOwner("test3",3,"www.test3.com")
            )
        )
        repoList.add(
            Repo(400,"0000004","TestRpo4",
                "This is forth test repo","kotlin", 30, RepoOwner("test4",4,"www.test4.com")
            )
        )
        repoList.add(
            Repo(500,"0000005","TestRpo5",
                "This is fifth test repo","java", 30, RepoOwner("test5",5,"www.test5.com")
            )
        )

        return repoList
    }
}