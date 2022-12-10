package app.suhasdissa.lyrics.ui.screens.secondary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import app.suhasdissa.lyrics.R
import app.suhasdissa.lyrics.backend.viewmodels.LyricsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongView(
    lyricId: Int,
    onClickEdit: (url: Int) -> Unit,
    modifier: Modifier = Modifier,
    lyricViewModel: LyricsViewModel = viewModel(factory = LyricsViewModel.Factory)
) {
    val song = lyricViewModel.song
    LaunchedEffect(Unit) {
        lyricViewModel.getSong(lyricId)
    }
    Scaffold(modifier = modifier.fillMaxSize(), topBar = {
        LargeTopAppBar(title = { Text(song.song) }, actions = {
            IconButton(onClick = { onClickEdit(lyricId) }) {
                Icon(
                    painter = painterResource(R.drawable.ic_settings),
                    contentDescription = "Edit"
                )
            }

        })
    }) { innerPadding ->
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(innerPadding).padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Card(
                    modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(song.song, style = MaterialTheme.typography.titleLarge)
                        Text(song.artistName, style = MaterialTheme.typography.titleSmall)
                    }
                }
            }
            item {
                Card(
                    modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        SelectionContainer(modifier.fillMaxWidth()) {
                            Text(song.lyric, style = MaterialTheme.typography.bodyLarge)

                        }
                    }
                }
            }
        }
    }
}