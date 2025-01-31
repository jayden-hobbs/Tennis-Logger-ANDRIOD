@Database(
    entities = [Player::class, Match::class],
    version = 1,
    exportSchema = false
)
abstract class TennisDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun matchDao(): MatchDao

    companion object {
        @Volatile
        private var INSTANCE: TennisDatabase? = null

        fun getDatabase(context: Context): TennisDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TennisDatabase::class.java,
                    "tennis_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
} 