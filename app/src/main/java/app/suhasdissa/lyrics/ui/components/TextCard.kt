package app.suhasdissa.lyrics.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextCard(
    modifier: Modifier = Modifier,
    clickAction: () -> Unit,
    song: String,
    artist: String
) {
    ElevatedCard(
        onClick = { clickAction() },
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()

    ) {
        Column(
            modifier
                .padding(10.dp)
        ) {
            Text(text = song, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier.height(10.dp))
            Text(text = artist, style = MaterialTheme.typography.titleMedium)
        }
    }
}