package com.example.android.coursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.grid.GridCells

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.coursesapp.ui.theme.CoursesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   CoursesApp()
                }
            }
        }
    }
}

@Composable
fun CourseList(courseList: List<Topic>,modifier: Modifier = Modifier){
    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(courseList) { course ->
            TopicCard(topic = course)
        }
    }

}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier){
    Row(modifier = modifier) {

            Image(painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
            modifier.padding(start = 68.dp, bottom = 68.dp ))

        Column(modifier.padding(top = 16.dp, end = 16.dp)) {
                Text(text = LocalContext.current.getString(topic.stringResourceId),
                modifier = modifier.padding(start= 16.dp))
            Row(modifier = modifier.padding(top = 8.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null,
                modifier = modifier.padding(start = 16.dp))
                Text(text = LocalContext.current.getString(topic.associatedNumberOfCourses),
                    modifier.padding(start = 8.dp))
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun CoursesApp() {
    CoursesAppTheme {
        CourseList(courseList = DataSource.topics)
    }
}