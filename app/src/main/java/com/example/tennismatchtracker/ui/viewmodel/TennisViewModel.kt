class TennisViewModel(private val repository: TennisRepository) : ViewModel() {
    val allMatches: StateFlow<List<Match>> = repository.allMatches.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    val allPlayers: StateFlow<List<Player>> = repository.allPlayers.stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    fun addMatch(match: Match) {
        viewModelScope.launch {
            repository.insertMatch(match)
        }
    }

    fun addPlayer(player: Player) {
        viewModelScope.launch {
            repository.insertPlayer(player)
        }
    }
} 