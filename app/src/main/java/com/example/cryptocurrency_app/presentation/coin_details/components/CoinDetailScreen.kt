package com.example.cryptocurrency_app.presentation.coin_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrency_app.data.remote.dto.TeamMember
import com.example.cryptocurrency_app.presentation.coin_list.components.CoinListItem
import com.example.cryptocurrency_app.presentation.coin_list.components.CoinListViewModel
import com.example.cryptocurrency_app.presentation.route.Screen
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
   coinDetailViewModel: CoinDetailViewModel = hiltViewModel()
   ){

    val state = coinDetailViewModel.state.value
    
    
    Box(modifier = Modifier.fillMaxSize()){

        state.coin?.let { coin->
            LazyColumn(modifier =   Modifier.fillMaxSize(),
                       contentPadding = PaddingValues(20.dp)
              )
                {
                  item {
                      Row(
                          modifier = Modifier.fillMaxWidth(),
                          horizontalArrangement = Arrangement.SpaceBetween
                      ) {
                          Text(text = "${coin.rank} ${coin.name} (${coin.symbol})",
                              style = MaterialTheme.typography.bodyMedium,
                              modifier = Modifier.weight(8f)
                          )
                          Text(text = if (coin.isActive) "Active" else "Inactive",
                               color = if (coin.isActive) Color.Green else Color.Red,
                              fontStyle = FontStyle.Italic,
                              textAlign = TextAlign.End,
                              modifier = Modifier
                                  .align(CenterVertically)
                                  .weight(2f)
                              )
                      }
                      Spacer(modifier = Modifier.height(15.dp))
                      Text(
                          text = coin.description,
                          style = MaterialTheme.typography.bodyMedium
                      )
                      Spacer(modifier = Modifier.height(15.dp))
                      Text(
                          text = "Tags",
                          style = MaterialTheme.typography.bodyMedium
                      )
                      Spacer(modifier = Modifier.height(15.dp))

                      FlowRow(
                          mainAxisSpacing = 10.dp,
                          crossAxisSpacing = 10.dp,
                          modifier = Modifier.fillMaxSize()
                      ) {
                          coin.tags.forEach{ coinTag ->
                              CoinTag(tag = coinTag)
                          }
                      }
                      Spacer(modifier = Modifier.height(15.dp))
                      Text(
                          text = "Team members",
                          style = MaterialTheme.typography.bodyMedium
                      )
                      Spacer(modifier = Modifier.height(15.dp))
                  }
                    items(coin.team){ teamMember ->
                        TeamListItem(teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp))
                        Divider()
                    }
                }
        }

        if (state.error.isNotBlank()){
            Text(text = state.error,
                 color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)

            )
        if (state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }



        }
    }

}